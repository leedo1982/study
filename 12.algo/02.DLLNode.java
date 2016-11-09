/**
 * 이중연결 리스트는 특정 노드로부터 양방향을 탐색할 수 있다.
 * 하지만 이중 연결 리스트에서는 이전 노드의 주소를 모르더라도 노드를 삭제할 수 있다.
 * 이중연결 리스트의 단점은 다음과 같다.
 * 1. 각 노드가 포인터를 하나씩 더 필요하기 대문에 저장 공간이 더 필요하다.
 * 2. 삽입, 삭제 연산이 조금 더 오래 걸린다.(포인터 연산이 더 많아져서이다) 
 * 
 *  삭제시 
 *  시간복잡도 : 크기 n인 리스트 전체를 담색하므로 O(n)
 *  공간복잡도 : 하나의 임시변수만을 만들기 때문에 O(1)
 */

public class DLLNode {
	private int data;
	private DLLNode next;
	private DLLNode previous;

	public DLLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}
	
	int getDLLLength(DLLNode headNode) {
		int length = 0;
		DLLNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position) {
		if(headNode == null){
			return nodeToInsert;
		}
		
		int size = getDLLLength(headNode);
		if(position > size + 1 || position <1){
			System.out.println("Position of nodeToInsert is invalid. The valid inputs are 1 to " + (size + 1));
			return headNode;
		}
		
		if(position == 1){
			nodeToInsert.setNext(headNode);
			headNode.setPrevious(nodeToInsert);
			return nodeToInsert;
		}else{
			DLLNode previousNode = headNode;
			int count  =1 ;
			while(count < position -1){
				previousNode = previousNode.getNext();
				count++;
			}
			
			DLLNode currentNode  = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			
			if(currentNode != null){
				currentNode.setPrevious(nodeToInsert);
			}
			
			previousNode.setNext(nodeToInsert);
			nodeToInsert.setPrevious(previousNode);
			
		}
		
		return headNode;
	}

	
	DLLNode DLLDelete(DLLNode headNode, int position){
		int size = getDLLLength(headNode);
		
		if(position > size + 1 || position <1){
			System.out.println("Position of nodeToInsert is invalid. The valid inputs are 1 to " + (size + 1));
			return headNode;
		}
		
		if(position == 1){
			DLLNode currentNode = headNode.getNext();
			headNode = null;
			currentNode.setPrevious(null);
			return currentNode;
		}else{
			DLLNode previousNode = headNode;
			int count  =1 ;
			while(count < position -1){
				previousNode = previousNode.getNext();
				count++;
			}
			
			DLLNode currentNode  = previousNode.getNext();
			DLLNode laterNode  = currentNode.getNext();

			previousNode.setNext(laterNode);
			if(laterNode != null){
				laterNode.setPrevious(previousNode);
			}
			currentNode = null;
		}
		
		return headNode;
	}

}
