package IteratorExample;

public class StreamMain {

    public static void main(String[] args) {

//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//
//        expressionExecutor.executeExpression(10,5, (a,b ) -> a +b);
//
//        expressionExecutor.executeExpression(3,4, FuncionalCaltulator::doubledibideAByB);

//        PoemBeautifier beautifier = new PoemBeautifier();
//
//        beautifier.beautify("hahahhaha");

        System.out.println("Using Stream to generate even numbers from 1 to 20aa");
        NumbersGenerator.generateEven(200);


    }
}