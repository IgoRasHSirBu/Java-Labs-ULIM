package kek;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);
        int oper;
        Menu meniu = new Menu();
        String nameFile;
        FisierStudenti studentFile = new FisierStudenti();

        do {
            meniu.clrscr();
            studentFile.checkAssign();
            oper = meniu.mainMenu();
            switch (oper) {

                case 1:
                    meniu.clrscr();
                    studentFile.checkAssign();
                    oper = meniu.opCreareFileMenu();

                    switch (oper) {
                        case 1:
                            meniu.clrscr();
                            studentFile.checkAssign();
                            meniu.opCreareFileMenuF1();
                            nameFile = read.next();
                            studentFile.creareFisier(nameFile);
                            break;
                        case 2:
                            meniu.clrscr();
                            studentFile.checkAssign();
                            meniu.opCreareFileMenuF2();
                            studentFile.creareFisier("studenti.txt");
                            break;
                        case 9:
                            meniu.clrscr();
                            break;
                        default:
                            if (oper != 0) {
                                meniu.errorOP(1);
                                meniu.pauseMenu();
                                meniu.clrscr();
                            }
                            break;
                    }
                    break;
                case 2:
                    meniu.clrscr();
                    studentFile.checkAssign();
                    meniu.opAfisareMeniu();
                    studentFile.afisareFisier();
                    break;
                case 3:// op adaugare student
                    meniu.clrscr();
                    studentFile.checkAssign();
                    meniu.opAddStudentsMenu();

                    if (studentFile.fileIsAssigned) {//remake
                        do {
                            oper = meniu.opAddStudentMenu();
                            switch (oper) {
                                case 1:
                                    studentFile.addDateInFisier();
                                    break;
                                case 2:
                                    break;
                                default:
                                    if ((oper != 0) && (oper != 9)) {
                                        meniu.errorOP(1);
                                        meniu.pauseMenu();
                                        meniu.clrscr();
                                    }
                                    break;
                            }
                        } while ((oper != 0) && (oper != 9));
                    } else {
                        meniu.errorOP(3);
                        meniu.pauseMenu();
                    }
                    break;
                case 4:
                    meniu.clrscr();
                    studentFile.checkAssign();
                    oper = meniu.opPrelucrareDate();
                    switch (oper) {
                        case 1:// folosind contains
                            meniu.clrscr();
                            studentFile.prelucrareDateDinFisierV1();
                            meniu.pauseMenu();
                            break;
                        case 2:// folosind charAt in algoritmul propriu
                            meniu.clrscr();
                            studentFile.prelucrareDateDinFisierV2();
                            meniu.pauseMenu();
                            break;
                        case 3:// algoritmul V3 care verifica indeferent de low/up case sau de keybord
                            meniu.clrscr();
                            studentFile.prelucrareDateDinFisierV3();
                            meniu.pauseMenu();
                            break;
                        case 9:
                            meniu.clrscr();
                            break;
                        default:
                            if (oper != 0) {
                                meniu.errorOP(1);
                                meniu.pauseMenu();
                                meniu.clrscr();
                            }
                        break;
                    }
                    break;
                case 5:
                    meniu.clrscr();
                    studentFile.checkAssign();
                    nameFile = meniu.opAsociereFileMeniu();
                    studentFile.assignFile(nameFile);
                    break;
                case 6:

                    meniu.clrscr();
                    studentFile.checkAssign();
                    oper = meniu.opElimenareDateMenu();

                    switch (oper) {
                        case 1:
                            meniu.clrscr();
                            meniu.opStergereFisier();
                            studentFile.eliminareFisier();
                            break;
                        case 2:
                            meniu.clrscr();
                            meniu.opEliminareStudentMeniu();
                            studentFile.eliminareStudent();
                            break;
                        case 9:
                            meniu.clrscr();
                            break;
                        default:
                            if (oper != 0) {
                                meniu.errorOP(1);
                                meniu.pauseMenu();
                                meniu.clrscr();
                            }
                    }

                    break;
                default:
                    if (oper != 0) {
                        meniu.errorOP(1);
                        meniu.pauseMenu();
                        meniu.clrscr();
                    }
                    break;
            }
        } while (oper != 0);
    }
}