package com.ai.opt.sso.ticket;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.jasig.cas.ticket.registry.AbstractDistributedTicketRegistry;

public class RedisTicketRegistry extends AbstractDistributedTicketRegistry {

	private static final Logger LOG = Logger.getLogger(RedisTicketRegistry.class);
	private static final int TGT_TIME = 43200000; // TGT最大空闲时间

	private static final int ST_TIME = 300000; // ST最大空闲时间

	private static final  String TICKECKKEY = "SSO-";
	
	@Override
	public void addTicket(final Ticket paramTicket) {
		LOG.debug("-------------------------------------------RedisTicketRegistry-----addTicket-----------------------------------------------begin");
		if(paramTicket == null){
			LOG.info("ticket is null");
			return;
		}
		LOG.debug("------------------------------------------ticket-----------------------------------------------"+paramTicket);
		String ticketKey = TICKECKKEY+paramTicket.getId();
		LOG.debug("------------------------------------------tecketId-----------------------------------------------"+ticketKey);
		int seconds = 0;
		if(paramTicket instanceof TicketGrantingTicket){
			seconds = TGT_TIME/1000;
		}else{
			seconds = ST_TIME/1000;
		}
		
		try {
			new TicketService().saveTicket(ticketKey,paramTicket,seconds);
			LOG.debug("------------------------------------------write-------------------------------ok----------------");
		} catch (Exception e) {
			LOG.error("--------------------------------------adding ticket to redis error.",e);
		}
		LOG.debug("-------------------------------------------RedisTicketRegistry-----addTicket-----------------------------------------------end");
	}

	@Override
	public boolean deleteTicket(final String ticketId) {
		if(ticketId == null){
			return false;
		}
		try {
			new TicketService().deleteTicket(TICKECKKEY+ticketId);
			return true;
		} catch (Exception e) {
			LOG.error("-----del ticket["+TICKECKKEY+ticketId+"] error!-----",e);
		}
		return false;
	}

	@Override
	public Ticket getTicket(final String ticketId) {
		return getProxiedTicketInstance(getRawTicket(ticketId));
	}

	private Ticket getRawTicket(String ticketId) {
		if(ticketId == null){
			return null;
		}
		Ticket ticket = null;
		try {
			ticket = new TicketService().getTicket(TICKECKKEY+ticketId);
		} catch (Exception e) {
			LOG.error("------------------------getting ticket from redis error.",e);
		}
		return ticket;
	}

	@Override
	public Collection<Ticket> getTickets() {
		throw new UnsupportedOperationException("GetTickets not supported.");
	}

	@Override
	protected boolean needsCallback() {
		return false;
	}

	@Override
	protected void updateTicket(final Ticket ticket) {
		addTicket(ticket);
	}

}
