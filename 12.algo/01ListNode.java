
/**
 * 일반적으로 '연결리스트'는 단일 연결 리스트를 의미한다.
 * 이 리스트틑 다음 노드를 가리키느느 다음(next) 포인터를 가진 노드들의 집합으로 이루어진다.
 * 마지막 노드는 NULL을 가리켜 리스트의 마지막임을 나타낸다.
 */

public class ListNode {
	private int data;
	private ListNode next;

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getNext() {
		return this.next;
	}

	int ListLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null) {
			return nodeToInsert;
		}
		int size = ListLength(headNode);
		if (position > size + 1 || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
			return headNode;
		}

		if (position == 1) { // 첫노드에 삽입
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else { // 중간과 끝에 노드를 삽입한다.
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}

	ListNode DeleteNodeFromLinkedList(ListNode headNode, int position) {
		int size = ListLength(headNode);
		if (position > size || position < 1) {
			System.out.println("Position of node to delete is invalid. The valid inputs are 1 to " + (size + 1));
			return headNode;
		}
		if (position == 1) { // 리스트가장 앞에서 삭제
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}else{ // 끝에 닿을 때까지 내부에서 노드 삭제
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position -1){
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}

	// 단일 연결 리스트 삭제하기
	void DeleteLinkedList(ListNode head){
		ListNode auxilaryNode, iterator = head;
		while(iterator != null){
			auxilaryNode = iterator.getNext();
			iterator = null; // 자바에서 이부분은 GG에 의해 관리
			iterator = auxilaryNode ; 
		}
	}
}
