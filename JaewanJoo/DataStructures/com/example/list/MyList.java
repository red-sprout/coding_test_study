package com.example.list;

public interface MyList<E> {
	
	void add(E e);
    
    void add(int index, E e);
	
	boolean contains(E e);
	
	E get(int index);
	
	int indexOf(E e);
	
	void remove(int index);
	
	void set(int index, E e);
	
	int size();
}
