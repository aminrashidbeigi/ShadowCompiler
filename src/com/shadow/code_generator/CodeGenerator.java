package com.shadow.code_generator;

import com.shadow.syntax.ExpressionTransitionTable;
import com.shadow.syntax.StatementTransitionTable;
import com.shadow.syntax.SyntaxStateMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amin Rashidbeigi on 6/11/2017.
 */
public class CodeGenerator {

    private int[] R;
    private String[] memory;
    private StatementTransitionTable stt;
    private SyntaxStateMachine ssm;
    private Map variableInMemoryIndex;
    private boolean[] isValidRegisterIndex;

    public CodeGenerator(ArrayList<String> tokens) {
        ssm = new SyntaxStateMachine(StatementTransitionTable.stt, ExpressionTransitionTable.ett, tokens, new int[1]);
        R = new int[4];
        isValidRegisterIndex = new boolean[4];
        memory = new String[1024];
        variableInMemoryIndex = new HashMap();
        Arrays.fill(R, 0);
        Arrays.fill(memory, "");
        Arrays.fill(isValidRegisterIndex, true);
        codeGeneratorStateMachine(tokens);

    }

    private int scs = 0;
    private void codeGeneratorStateMachine(ArrayList<String> tokens){
        int ecs = 0;

        for (String token : tokens){
            int key;
            if (token.equals(";")) scs = 0;
            if (scs == 14 || scs == 15 || scs == 7){
                key = ssm.expressionKeywordValueGenerator(token);
                ecs = ExpressionTransitionTable.ett[ecs][key];
                expressionCodeGeneratorHandler(ecs, token);
            } else {
                key = ssm.statementKeywordValueGenerator(token);
                scs = stt.stt[scs][key];
                codeGeneratorStateHandler(scs, token);
            }
        }
    }

    private void expressionCodeGeneratorHandler(int cs, String token){
        switch (cs){
            case 1 : {
                checkCodeToPrint(token);
                break;
            }
        }

    }

    private void codeGeneratorStateHandler(int cs, String token){
        switch (cs){
            case 0 : {

                break;
            }

            case 2 : {
                memoryFiller(token);
                break;
            }

            case 4 : {
                checkCodeToPrint(token);
                break;
            }

            case 9 : {
                memoryFiller(token);
                break;
            }

            case 11: {
                checkCodeToPrint(token);
                break;
            }

            default:
                break;
        }

    }

    private void memoryFiller(String data){
        int lastEmptyMemoryWordIndex = 1024;
        for (int i = 1023; i > 0; i--){
            if (memory[i].equals("")){
                lastEmptyMemoryWordIndex = i;
                break;
            }
        }

        System.out.println(data + " --> " + lastEmptyMemoryWordIndex);
        variableInMemoryIndex.put(data, lastEmptyMemoryWordIndex);
        memory[lastEmptyMemoryWordIndex] = data;
    }

    private int emptyRegisterIndexFinder(){
        int index = 0;

        for (int i = 0; i < 4; i++){
            if (isValidRegisterIndex[i]){
                index = i;
                break;
            }
        }

        return index;
    }

    private void checkCodeToPrint(String token){
        int key = ssm.statementKeywordValueGenerator(token);
        if (key == 17){
            int number = Integer.parseInt(token);
            String bits  = String.format("%"+Integer.toString(16)+"s",Integer.toBinaryString(number)).replace(" ","0");
            int registerIndex = emptyRegisterIndexFinder();
            System.out.println("bits: " + bits);
            System.out.println("R_" + registerIndex);
            mil(registerIndex, bits);
            mih(registerIndex, bits);
        } else if (key == 12) {
            char[] chars = token.toCharArray();
            String bits  = String.format("%"+Integer.toString(16)+"s",Integer.toBinaryString((int)chars[1])).replace(" ","0");
            int registerIndex = emptyRegisterIndexFinder();
            System.out.println("bits: " + bits);
            System.out.println("R_" + registerIndex);
            mil(registerIndex, bits);
            mih(registerIndex, bits);
        } else if (token.equals("true") || token.equals("false")){
            int number;
            if (token.equals("true")) number = 1;
            else number = 0;
            String bits  = String.format("%"+Integer.toString(16)+"s",Integer.toBinaryString(number)).replace(" ","0");
            int registerIndex = emptyRegisterIndexFinder();
            System.out.println("bits: " + bits);
            System.out.println("R_" + registerIndex);
            mil(registerIndex, bits);
            mih(registerIndex, bits);

        }
    }

    private void mil(int registerIndex, String bits){
        System.out.print("1111" + binaryRegisterIndex(registerIndex) + "00");
        for (int i = 8; i < 16; i++)
            System.out.print(bits.toCharArray()[i]);
        System.out.println();
        isValidRegisterIndex[registerIndex] = true;
    }

    private void mih(int registerIndex, String bits){
        System.out.print("1111" + binaryRegisterIndex(registerIndex) + "01");
        for (int i = 0; i < 8; i++)
            System.out.print(bits.toCharArray()[i]);
        System.out.println();
        isValidRegisterIndex[registerIndex] = true;
    }

    private String binaryRegisterIndex(int number){
        switch (number){
            case 0 :
                return "00";
            case 1 :
                return "01";
            case 2:
                return "10";
            case 3:
                return "11";
        }
        return "00";
    }


    private String binaryGenerator(int n, int bits) {
        String binary = "";
        for(int i = 0; i < bits; ++i, n/=2) {
            switch (n % 2) {
                case 0:
                    binary = "0" + binary;
                case 1:
                    binary = "1" + binary;
            }
        }
        return binary;
    }

}
