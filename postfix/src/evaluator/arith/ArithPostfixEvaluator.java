package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple
 * arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;

	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator() {
		// TODO Initialize to your LinkedStack
		stack = new LinkedStack<Operand<Integer>>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch (type) {
			case OPERAND:
				// TODO What do we do when we see an operand?
				stack.push(token.getOperand());
				break;
			case OPERATOR:
				// TODO What do we do when we see an operator?
				Operator<Integer> op = token.getOperator();
				if (op.getNumberOfArguments() == 1) op.setOperand(0, stack.pop());
				else {
					op.setOperand(1, stack.pop());
					op.setOperand(0, stack.pop());
				}
				Operand<Integer> res = op.performOperation();
				stack.push(res);
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}
		}
		// TODO What do we return?
		Integer result = stack.pop().getValue();
		if (!stack.isEmpty()) throw new IllegalPostfixExpressionException();
		return result;
	}

}
