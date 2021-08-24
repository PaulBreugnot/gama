/*******************************************************************************************************
 *
 * ObjectArrayList.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.RandomAccess;

/**
 * The Class ObjectArrayList.
 *
 * @author jezek2
 * @param <T> the generic type
 */
public final class ObjectArrayList<T> extends AbstractList<T> implements RandomAccess, Externalizable {

	/** The array. */
	private T[] array;
	
	/** The size. */
	private int size;

	/**
	 * Instantiates a new object array list.
	 */
	public ObjectArrayList() {
		this(16);
	}
	
	/**
	 * Instantiates a new object array list.
	 *
	 * @param initialCapacity the initial capacity
	 */
	@SuppressWarnings("unchecked")
	public ObjectArrayList(int initialCapacity) {
		array = (T[])new Object[initialCapacity];
	}
	
	@Override
	public boolean add(T value) {
		if (size == array.length) {
			expand();
		}
		
		array[size++] = value;
		return true;
	}

	@Override
	public void add(int index, T value) {
		if (size == array.length) {
			expand();
		}

		int num = size - index;
		if (num > 0) {
			System.arraycopy(array, index, array, index+1, num);
		}

		array[index] = value;
		size++;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		T prev = array[index];
		System.arraycopy(array, index+1, array, index, size-index-1);
		array[size-1] = null;
		size--;
		return prev;
    }
	
	/**
	 * Expand.
	 */
	@SuppressWarnings("unchecked")
	private void expand() {
		T[] newArray = (T[])new Object[array.length << 1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;
	}

	/**
	 * Removes the quick.
	 *
	 * @param index the index
	 */
	public void removeQuick(int index) {
		System.arraycopy(array, index+1, array, index, size - index - 1);
		array[size-1] = null;
		size--;
	}

	public T get(int index) {
		if (index >= size) throw new IndexOutOfBoundsException();
		return array[index];
	}

	/**
	 * Gets the quick.
	 *
	 * @param index the index
	 * @return the quick
	 */
	public T getQuick(int index) {
		return array[index];
	}

	@Override
	public T set(int index, T value) {
		if (index >= size) throw new IndexOutOfBoundsException();
		T old = array[index];
		array[index] = value;
		return old;
	}

	/**
	 * Sets the quick.
	 *
	 * @param index the index
	 * @param value the value
	 */
	public void setQuick(int index, T value) {
		array[index] = value;
	}

	public int size() {
		return size;
	}
	
	/**
	 * Capacity.
	 *
	 * @return the int
	 */
	public int capacity() {
		return array.length;
	}
	
	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public int indexOf(Object o) {
		int _size = size;
		T[] _array = array;
		for (int i=0; i<_size; i++) {
			if (o == null? _array[i] == null : o.equals(_array[i])) {
				return i;
			}
		}
		return -1;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(size);
		for (int i=0; i<size; i++) {
			out.writeObject(array[i]);
		}
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		size = in.readInt();
		int cap = 16;
		while (cap < size) cap <<= 1;
		array = (T[])new Object[cap];
		for (int i=0; i<size; i++) {
			array[i] = (T)in.readObject();
		}
	}
	
}
