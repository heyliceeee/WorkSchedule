package workschedule;

import WorkSchedule.WorkSchedule;
import WorkSchedule.WorkSchedule.Hour;

public class Main {

    public static void main(String[] args) {

        /**
         * WorkSchedule class
         * gerir um calendario de trabalho dos employees de uma empresa.
         * o tempo está dividido em unidades de uma hora e as horas são identificadas por inteiros
         * pra cada hora, o calendario armazena o nº de employees que são necessarios nessa altura
         * p.ex. poderá ocorrer que durante os dias da semana haja a necessidade de 5 employees a trabalhar simultaneamente e - durante a noite e fins de semana
         * pra cada hora o calendario tbm armazena o nome dos employees que estão escalonados pra trabalhar naquela hora
         */


        /**
         * cria um novo calendario, o qual contém as horas 0, 1, 2, ..., size-1
         * onde pra cada hora o nº de employees necessarios está a 0 e n existem employees escalonados
         */
        WorkSchedule workSchedule = new WorkSchedule(8);

        /**
         * retorna o objeto Hour:
         * public class Hour {
         *      int requiredNumber; //nº necessario de employees pra trabalhar naquela hora
         *      String[] workingEmployees; //nome dos employees
         *  }
         */
        Hour result = workSchedule.readSchedule(7);
   
        /**
         * nº employees necessários entre o intervalo starttime e endtime:
         * nemployee - nº de employees
         * starttime - hora de inicio
         * endtime - hora de fim
         */
        workSchedule.setRequiredNumber(5, 6, 14);

        /**
         * retorna boolean
         * escalona employee pra trabalhar durante as horas entre starttime e endtime
         */
        Boolean addWorkingPeriod = workSchedule.addWorkingPeriod("Alice Dias", 6, 14);
          
        /**
         * retorna uma list de tds os employees a trabalhar numa entre entre starttime a endttime
         */
        String[] listEmployees = workSchedule.workingEmployees(6, 14);
    
        /**
         * retorna o tempo + proximo a contar o tempo/hora atual pra o qual a totalidade de employees necessários ainda n foi escalonada
         */
        int nextIncomplete = workSchedule.nextIncomplete(7);
    }
}
