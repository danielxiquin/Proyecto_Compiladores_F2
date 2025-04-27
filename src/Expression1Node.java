    public class Expression1Node extends ASTNode {
        private String operator;
        private NumbersConditionNode right;
        private Expression1Node next;
        private boolean hasExpression;

        public Expression1Node(int line, int column) {
            super(line, column);
            this.hasExpression = false;
        }

        public Expression1Node(int line, int column, String operator, NumbersConditionNode right, Expression1Node next) {
            super(line, column);
            this.operator = operator;
            this.right = right;
            this.next = next;
            this.hasExpression = true;
        }

        public boolean hasExpression() {
            return hasExpression;
        }

        public String getOperator() {
            return operator;
        }

        public NumbersConditionNode getRight() {
            return right;
        }

        public Expression1Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            if (hasExpression) {
                return "Expression1(" + operator + ", " + right + ", " + next + ")";
            } else {
                return "Expression1()";
            }
        }
    }