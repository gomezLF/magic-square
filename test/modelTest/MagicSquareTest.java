package modelTest;

import cunstomtExceptions.OddNumberException;
import model.MagicSquare;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MagicSquareTest {

    private MagicSquare magicSquare;
    private int[][] matrix;

    private void setupScenary1(){

    }

    private void setupScenary2(){
        magicSquare = new MagicSquare(6, MagicSquare.TOP, MagicSquare.NORTHEAST);
    }

    private void setupScenary3(){
        magicSquare = new MagicSquare(7, MagicSquare.TOP, MagicSquare.NORTHEAST);
    }

    private void setupScenary4(){
        magicSquare = new MagicSquare(3, MagicSquare.TOP, MagicSquare.NORTHEAST);
        matrix = new int[3][3];

        matrix[0][0] = 8;
        matrix[0][1] = 1;
        matrix[0][2] = 6;
        matrix[1][0] = 3;
        matrix[1][1] = 5;
        matrix[1][2] = 7;
        matrix[2][0] = 4;
        matrix[2][1] = 9;
        matrix[2][2] = 2;
    }

    private void setupScenary5(){
        magicSquare = new MagicSquare(3, MagicSquare.TOP, MagicSquare.NORTHWEST);
        matrix = new int[3][3];


        matrix[0][0] = 6;
        matrix[0][1] = 1;
        matrix[0][2] = 8;
        matrix[1][0] = 7;
        matrix[1][1] = 5;
        matrix[1][2] = 3;
        matrix[2][0] = 2;
        matrix[2][1] = 9;
        matrix[2][2] = 4;
    }

    private void setupScenary6(){
        magicSquare = new MagicSquare(3, MagicSquare.DOWN, MagicSquare.SOUTHEAST);
        matrix = new int[3][3];

        matrix[0][0] = 4;
        matrix[0][1] = 9;
        matrix[0][2] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 5;
        matrix[1][2] = 7;
        matrix[2][0] = 8;
        matrix[2][1] = 1;
        matrix[2][2] = 6;

    }

    private void setupScenary7(){
        magicSquare = new MagicSquare(3, MagicSquare.DOWN, MagicSquare.SOUTHWEST);
        matrix = new int[3][3];

        matrix[0][0] = 2;
        matrix[0][1] = 9;
        matrix[0][2] = 4;
        matrix[1][0] = 7;
        matrix[1][1] = 5;
        matrix[1][2] = 3;
        matrix[2][0] = 6;
        matrix[2][1] = 1;
        matrix[2][2] = 8;
    }

    private void setupScenary8(){
        magicSquare = new MagicSquare(3, MagicSquare.RIGHT, MagicSquare.NORTHEAST);
        matrix = new int[3][3];

        matrix[0][0] = 2;
        matrix[0][1] = 7;
        matrix[0][2] = 6;
        matrix[1][0] = 9;
        matrix[1][1] = 5;
        matrix[1][2] = 1;
        matrix[2][0] = 4;
        matrix[2][1] = 3;
        matrix[2][2] = 8;
    }

    private void setupScenary9(){
        magicSquare = new MagicSquare(3, MagicSquare.RIGHT, MagicSquare.SOUTHEAST);
        matrix = new int[3][3];

        matrix[0][0] = 4;
        matrix[0][1] = 3;
        matrix[0][2] = 8;
        matrix[1][0] = 9;
        matrix[1][1] = 5;
        matrix[1][2] = 1;
        matrix[2][0] = 2;
        matrix[2][1] = 7;
        matrix[2][2] = 6;
    }

    private void setupScenary10(){
        magicSquare = new MagicSquare(3, MagicSquare.LEFT, MagicSquare.NORTHWEST);
        matrix = new int[3][3];

        matrix[0][0] = 6;
        matrix[0][1] = 7;
        matrix[0][2] = 2;
        matrix[1][0] = 1;
        matrix[1][1] = 5;
        matrix[1][2] = 9;
        matrix[2][0] = 8;
        matrix[2][1] = 3;
        matrix[2][2] = 4;
    }

    private void setupScenary11(){
        magicSquare = new MagicSquare(3, MagicSquare.LEFT, MagicSquare.SOUTHWEST);
        matrix = new int[3][3];

        matrix[0][0] = 8;
        matrix[0][1] = 3;
        matrix[0][2] = 4;
        matrix[1][0] = 1;
        matrix[1][1] = 5;
        matrix[1][2] = 9;
        matrix[2][0] = 6;
        matrix[2][1] = 7;
        matrix[2][2] = 2;
    }



    @Test
    void magicSquareTest(){
        setupScenary1();

        int size = 5;
        String startPoint = MagicSquare.RIGHT;
        String orientation = MagicSquare.NORTHEAST;

        MagicSquare newMagicSquare = new MagicSquare(size, startPoint, orientation);

        assertNotNull(newMagicSquare, "The new Magic Square is null");

        assertEquals(size, newMagicSquare.getSize(), "The size of the magic square is not the same");
        assertEquals(startPoint, newMagicSquare.getStartPoint(), "The start point of the magic square is not the same");
        assertEquals(orientation, newMagicSquare.getOrientation(), "The orientation of the magic square is not the same");

        assertNotNull(newMagicSquare.getMatrix(), "The matrix of the magic square is null");
    }

    @Test
    void createMagicSquareExceptionTest(){
        //Aqui se prueba que lance la excepcion cuando el tamaño del cuadrado magico es un numero par
        setupScenary2();

        try {
            magicSquare.createMagicSquare();
            fail("The size of the magic square is an even number");
        }catch(OddNumberException e){
            assertTrue(true);
        }

        //Aqui se prueba que no lance la excepcion
        setupScenary3();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }


    }

    @Test
    void createMagicSquareTopTest(){
        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Top y orientacion noreste, este debidamente colocado
        setupScenary4();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[0][1], matrix[0][1], "the magic squares are not the same");

        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Top y orientacion noroeste, este debidamente colocado
        setupScenary5();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[0][1], matrix[0][1], "the magic squares are not the same");
    }

    @Test
    void createMagicSquareDownTest(){
        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Down y orientacion noroeste, este debidamente colocado
        setupScenary6();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[2][1], matrix[2][1], "the magic squares are not the same");

        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Top y orientacion suroeste, este debidamente colocado
        setupScenary7();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[2][1], matrix[2][1], "the magic squares are not the same");
    }

    @Test
    void createMagicSquareRightTest(){
        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Right y orientacion noreste, este debidamente colocado
        setupScenary8();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[1][2], matrix[1][2], "the magic squares are not the same");

        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Right y orientacion sureste, este debidamente colocado
        setupScenary9();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[1][2], matrix[1][2], "the magic squares are not the same");
    }

    @Test
    void createMagicSquareLeftTest(){
        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Left y orientacion noroeste, este debidamente colocado
        setupScenary10();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[1][0], matrix[1][0], "the magic squares are not the same");

        //Aqui se prueba que el primer numero de la matriz generada con punto de inicio en Left y orientacion suroeste, este debidamente colocado
        setupScenary11();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertEquals(magicSquare.getMatrix()[1][0], matrix[1][0], "the magic squares are not the same");
    }

    @Test
    void createMagicSquareNortheastTest(){
        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Top y orientacion noreste, esten debidamente colocados
        setupScenary4();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }


        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Right y orientacion noreste, esten debidamente colocados
        setupScenary8();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void createMagicSquareNorthwestTest(){
        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Top y orientacion noroeste, esten debidamente colocados
        setupScenary5();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }


        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Left y orientacion noroeste, esten debidamente colocados
        setupScenary10();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void createMagicSquareSoutheastTest(){
        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Down y orientacion sureste, esten debidamente colocados
        setupScenary6();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }


        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Right y orientacion sureste, esten debidamente colocados
        setupScenary9();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void createMagicSquareSouthwestTest(){
        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Down y orientacion suroeste, esten debidamente colocados
        setupScenary7();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }


        //Aqui se prueba que los elementos de la matriz generada con punto de inicio en Left y orientacion suroeste, esten debidamente colocados
        setupScenary11();

        try{
            magicSquare.createMagicSquare();
        }catch(OddNumberException e){
            fail("The size of the magic square is an even number");
        }

        assertArrayEquals(magicSquare.getMatrix(), matrix, "the magic squares are not the same");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, magicSquare.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void calculateMagicConstantTest(){
        setupScenary3();

        int magicConstant = 175;

        try{
            magicSquare.createMagicSquare();
        }catch (OddNumberException e){
            fail();
        }

        assertNotNull(magicSquare.getMatrix(), "The magic constant was not created");
        assertEquals(magicSquare.getMagicConstant(), magicConstant, "The magic constant is not the same");
    }

}