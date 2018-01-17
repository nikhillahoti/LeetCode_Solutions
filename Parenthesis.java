class Solution {
    public boolean isValid(String s) {
    Stack<String> stack = new Stack<String>();
		boolean flag = true;

		for ( int i = 0 ; i < s.length() && flag ; i++) {
			String currVar = s.charAt(i) + "";

			if(new String(" ").equals(currVar)) {
				continue;
			}

			if(new String(currVar).equals("(") || new String(currVar).equals("{") || new String(currVar).equals("[") ) {
				stack.push(currVar + "");
			}
			else
			{
                if (stack.isEmpty()) {
					flag = false;
					continue;
				}
				String stackElement = stack.pop();
				switch(currVar) {
					case "}":
						if(!stackElement.equals("{")) {
							flag = false;
						}
						break;
					case "]":
						if(!stackElement.equals("[")) {
							flag = false;
						}
						break;
					case ")":
						if(!stackElement.equals("(")) {
							flag = false;
						}
						break;
					default:
						flag = false;
				}
			}
		}

		if(flag && stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
    }
}
