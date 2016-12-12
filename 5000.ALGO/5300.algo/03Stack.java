
/**
 *	스택은 삽입과 삭제가 한쪽 끝에서 이루어지는, 순서가 매겨진 리스트이다.
 *	이 끝을 탑(top)라고 부르며, 제일 마지막에 추가된 항목이 제일 먼저 삭제된다.(Last In First Out) 
 *	스택의 삽입을 푸시(push), 삭제를 팝(pop) 
 *	빈 스택으로부터 항목을 팝하려는 것을 언더플로우(underflow)
 *  가득찬 스택에 항목을 푸시하려는 거을 오버플로우(overflow)
 *  언더플로우와 오버플로우는 일반적으로 예외처리~
 *	
 *	스택의 보조적 연산들
 *	int Top() :  스택에 마지막에 추가된 항목을 삭제하지 않고 리턴
 *  int Size() : 스택에 저장된 항목의 개수를 리턴
 *  int IsEmptyStack() : 스택에 항목이 저장되어 있는지 아닌지를 확인
 *  int IsFullStack() : 스택이 가득 찼는지 아닌지를 확인 
 *
 *	직접적인 적용사례 
 *	- 괄호 짝맞추기
 *	- 인픽스(inFix)를 포스트픽스(postFix)로 변환
 * 	- 포스트 픽스 수식 계산하기
 * 	- 함수 호출 구현하기(재귀 포함)
 * 	- 스팬(span)  찾기(주식 시장에서 스팬 찾기)
 * 	- 웹 브라우저에서 방문한 페잊 기록 관리( 뒤로가기 버튼)
 * 	- 텍스트 에디터에서 작업취소(Undo)과정
 * 	- HTML과 XML에서 태그 짝맞추기
 * 
 *	한계 :  스택크기의 최대값이 미리 정해져야하고 바꿜수 없다. 꽉찬 스택에 새항목을 푸시하려면 이 구현에만 예외가 발생한다. 
 *  해결방법 : 점진적 확장법과 반복적인 두배확장법
 */
public class ArrayStack {
	private int top;
	private int capacity;
	private int[] array;
	public ArrayStack(){
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top== -1);
	}
	
	public boolean isStackFull(){
		return (top == capacity -1);
	}
	
	public void push(int data){
		if(isStackFull()){
			System.out.println("Stack Overflow!!!");
		}else {
			array[++top] = data;
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty!!!");
			return 0;
		}else{
			return (array[top--]);
		}
	}
			
	public void deleteStack(){
		top = -1;
	}
}
