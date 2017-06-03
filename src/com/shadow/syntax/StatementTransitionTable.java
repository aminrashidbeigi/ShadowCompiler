package com.shadow.syntax;

/**
 * Created by Amin Rashidbeigi on 6/3/2017.
 */
public class  StatementTransitionTable {

    public final static int[][] stt = new int[][] {
        // Int	Char	Bool	While	If	var	(	)	=	Op	;	,	‘ ‘	+=	Eif	Ewh	Inc	Num
            { 8,     1,	5,	15,	14,	12,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //0
            {-1,	-1,	-1,	-1,	-1,	2,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //1
            {-1,	-1,	-1,	-1,	-1,	1,	-1,	-1,	3,	-1,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //2
            {-1,	-1,	-1,	-1,	-1,	4,	3,	-1,	-1,	-1,	-1,	-1,	4,	-1,	-1,	-1,	-1,	-1}, //3
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	4,	-1,	-1,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //4
            {-1,	-1,	-1,	-1,	-1,	6,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //5
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	7,	-1,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //6
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //7
            {-1,	-1,	-1,	-1,	-1,	9,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //8
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	10,	-1,	0,	8,	-1,	-1,	-1,	-1,	-1,	-1}, //9
            {-1,	-1,	-1,	-1,	-1,	11,	10,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	11}, //10
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	11,	-1,	10,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //11
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	10,	-1,	-1,	-1,	-1,	10,	-1,	-1,	13,	-1}, //12
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	0,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //13
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	0,	-1,	-1,	-1}, //14
            {-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	0,	-1,	-1} //15
    };
}