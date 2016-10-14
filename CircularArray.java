import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	
	private T[] items;
	private int head=0;
	
	public CircularArray(int size){
		items=(T[])new Object[size];
	}
	
	private int convert(int index){
		while(index<0){
			index+=items.length;
		}
		return (head+index)%items.length;
	}
	
	public void rotate(int shiftRight){
		head=convert(shiftRight);
	}
	
	public T get(int i){
		if(i<0||i>=items.length){
			throw new java.lang.IndexOutOfBoundsException("Not valid");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item){
		if(i<0||i>=items.length){
			throw new java.lang.IndexOutOfBoundsException("Not valid");
		}
		items[convert(i)]=item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI>{
		
		private int _current=-1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> array) {
			// TODO Auto-generated constructor stub
			_items=array.items;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return _current<items.length-1;
		}

		@Override
		public TI next() {
			// TODO Auto-generated method stub
			_current++;
			TI item=(TI) _items[convert(_current)];
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("...");
			
		}
		
	}

}
