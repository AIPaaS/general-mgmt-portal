package com.ai.opt.sso.ticket;

import org.jasig.cas.ticket.Ticket;

public class TicketService{

	public void saveTicket(String key,Ticket ticket ,int secends){
		CommonService.getInstance().saveObj(key, ticket, secends);
	}

	public Ticket getTicket(String ticketId) {
		return (Ticket) CommonService.getInstance().getValue(ticketId);
	}

	public void deleteTicket(String key) {
		CommonService.getInstance().removeObj(key);
	}
}
