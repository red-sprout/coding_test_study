package test;

// 연습4-4
// int형 고정 길이 큐(링 버퍼를 사용하지 않고 구현)

public class IntArrayQueue {
	private int [] que;			// 큐의 본체
	private int capacity;		// 큐의 용량
	private int num;			// 현재 데이터 개수

	//--- 실행 시 예외 : 큐가 비어 있음 ---//
	public class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() { }
	}

	//--- 실행 시 예외 : 큐가 가득 참 ---//
	public class OverflowIntArrayQueueException extends RuntimeException {
		public OverflowIntArrayQueueException() { }
	}


	//--- 생성자 ---//
	public IntArrayQueue(int maxlen) {
		num = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];			// 큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {		// 생성할 수 없음
			capacity = 0;
		}
	}

	//--- 큐에 데이터를  인큐 ---//
	public int enque(int x) throws OverflowIntArrayQueueException {
		if (num >= capacity)
			throw new OverflowIntArrayQueueException();			// 큐가 가득 참
		que[num++] = x;
		return x;
	}

	//--- 큐에서 데이터를  디큐 ---//
	public int deque() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException();				// 큐가 비어 있음
		int x = que[0];
		for (int i = 0; i < num - 1; i++)
			que[i] = que[i + 1];
		num--;
		return x;
	}

	//--- 큐에서 데이터를 피크(맨앞 데이터를 들여다봄 ) ---*/
	public int peek() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException();			// 큐가 비어 있음
		return que[num - 1];
	}

	//--- 큐에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++)
			if (que[i]  == x)					// 검색 성공
				return i;
		return -1;									// 검색 실패
	}

	//--- 큐를 비웁니다 ---//
	public void clear() {
		num = 0;
	}

	//--- 큐의 용량을 반환합니다 ---//
	public int capacity() {
		return capacity;
	}

	//--- 큐에 쌓여있는 데이터수를 반환합니다 ---//
	public int size() {
		return num;
	}

	//--- 큐가 비어 있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

	//--- 큐 안의 모든 데이터를 맨앞 → 맨끝의 순서로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[i] + " ");
			System.out.println();
		}
	}
}

