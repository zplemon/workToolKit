package com.workToolKit.github.example.util.queue;

public interface Callback<T extends QueueAble> {
	public void callback(T queueAble);
}