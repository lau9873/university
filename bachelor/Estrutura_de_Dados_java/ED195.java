public class ED195{
    public static boolean balanced(String s){
	MyStack<Character> pilha = new LinkedListStack<>();
	for (int i=0; i<s.length();i++) {
	    if(pilha.isEmpty())
		pilha.push(s.charAt(i));
	    else if(((pilha.top().equals('(') && s.charAt(i)==')')||((pilha.top().equals('[') && s.charAt(i)==']')))){
		pilha.pop();
	    }
	    else 
		pilha.push(s.charAt(i));
	}

	return (pilha.isEmpty());
    }
}
