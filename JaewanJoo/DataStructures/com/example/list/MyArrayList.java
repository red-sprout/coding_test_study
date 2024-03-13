package com.example.list;

public class MyArrayList<E> implements MyList<E> {
	private Object[] array;
	private int size;
	private int index;

	public MyArrayList() {
		super();
		this.size = 1;
		this.array = new Object[this.size];
		this.index = -1;
	}

	public void doubling() {
		this.size = this.size * 2;
		Object[] newArray = new Object[this.size];
		for(int i = 0; i < array.length; i++) {
			 newArray[i] = array[i];
		}
		this.array = newArray;
		System.out.println("Doubling! " + this.size / 2 + " -> " + this.size);
	}
	
	@Override
	public void add(E e) {
		add(this.index + 1, e);
	}
	
	@Override
	public void add(int index, E e) {
		if(index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + this.size());
		}
		
		if(this.index == this.size - 1) {
			doubling();
		}
		
		for(int i = this.index; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = e;
		this.index++;
	}

	@Override
	public boolean contains(E e) {
		for(int i = 0; i <= this.index; i++) {
			if(array[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		return (E)array[index];
	}

	@Override
	public int indexOf(E e) {
		for(int i = 0; i <= this.index; i++) {
			if(array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		for(int i = index; i < this.index; i++) {
			array[i] = array[i + 1];
		}
		this.index--;
	}

	@Override
	public void set(int index, E e) {
		array[index] = e;
	}

	@Override
	public int size() {
		return this.index + 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i <= this.index - 1; i++) {
			sb.append((E)array[i]).append(", ");
		}
		if(this.index >= 0) sb.append((E)array[this.index]);
		sb.append("]");
		return sb.toString();
	}
}
