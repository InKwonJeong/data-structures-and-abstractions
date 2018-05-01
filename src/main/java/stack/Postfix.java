
public class Postfix 
{
	public static Double evaluatePostfix(StringBuilder postfix)
	{
		StackInterface<String> valueStack = new ArrayStack<>();
		int n = 0;
		double result=0;
		while(n < postfix.length())
		{
			char nextCharacter = postfix.charAt(n);
			double operandTwo = 0;
			double operandOne = 0;
			switch(nextCharacter)
			{
				case '+':
					operandTwo = Double.parseDouble(valueStack.pop());
					operandOne = Double.parseDouble(valueStack.pop());
					result = operandOne + operandTwo;
					valueStack.push(String.valueOf(result));
					break;
				case '-':
					operandTwo = Double.parseDouble(valueStack.pop());
					operandOne = Double.parseDouble(valueStack.pop());
					result = operandOne - operandTwo;
					valueStack.push(String.valueOf(result));
					break;
				case '*':
					operandTwo = Double.parseDouble(valueStack.pop());
					operandOne = Double.parseDouble(valueStack.pop());
					result = operandOne * operandTwo;
					valueStack.push(String.valueOf(result));
					break;
				case '/':
					operandTwo = Double.parseDouble(valueStack.pop());
					operandOne = Double.parseDouble(valueStack.pop());
					result = operandOne / operandTwo;
					valueStack.push(String.valueOf(result));
					break;
				case '^':
					operandTwo = Double.parseDouble(valueStack.pop());
					operandOne = Double.parseDouble(valueStack.pop());
					result = Math.pow(operandOne, operandTwo);
					valueStack.push(String.valueOf(result));
					break;
				default:
					valueStack.push(String.valueOf(nextCharacter));
					break;
			}
			n++;
		}
		return Double.parseDouble(valueStack.peek());
	}
	public static StringBuilder convertToPostfix(String infix)
	{
		StackInterface<Character> operatorStack = new ArrayStack<>();
		StringBuilder postfix = new StringBuilder();
		char topOperator=' ';
		int n = 0;
		
		while(n < infix.length())
		{
			char nextCharacter = infix.charAt(n);
			switch(nextCharacter)
			{
				case '^':
					operatorStack.push(nextCharacter);
					break;
				case '+': case '-': case '*': case '/':
					while(!operatorStack.isEmpty() &&
							compareOperator(nextCharacter,operatorStack.peek()))
					{
						postfix.append(operatorStack.peek());
						operatorStack.pop();
					}
					operatorStack.push(nextCharacter);
					break;
				case '(':
					operatorStack.push(nextCharacter);
					break;
				case ')':
					topOperator = operatorStack.pop();
					while(topOperator != '(')
					{
						postfix.append(topOperator);
						topOperator = operatorStack.pop();
					}
					break;
				default :
					postfix.append(nextCharacter);
					break;
			}
			n++;
		}
		while(!operatorStack.isEmpty())
		{
			topOperator = operatorStack.pop();
			postfix.append(topOperator);
		}
		return postfix;
	}

	private static boolean compareOperator(char nextOperator, char topOperator)
	{
		int next=0;
		int top=-1; // when stack's top entry is '(', return false
		switch(nextOperator)
		{
			case '+': case '-':
				next = 0;
				break;
			case '*': case '/':
				next = 1;
				break;
			case '^':
				next = 2;
				break;
			default:
				break;
		}
		
		switch(topOperator)
		{
			case '+': case '-':
				top = 0;
				break;
			case '*': case '/':
				top = 1;
				break;
			case '^':
				top = 2;
				break;
			default:
				break;
		}
		return next <= top;
	}
}