package com.ai.opt.sso.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SerializeUtil {
	
	private SerializeUtil(){}
	
	/**
	 * 反序列化
	 * @param data 需要反序列化的数据
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object unserialize(byte[] data) throws IOException, ClassNotFoundException{
		if(data == null){
			return null;
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	/**
	 * 序列化
	 * @param obj 需要被序列化的对象
	 * @return
	 * @throws IOException
	 */
	public static byte[] serialize(Object obj) throws IOException{
		if(obj == null){
			return new byte[0];
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		return bos.toByteArray();
	}

}
