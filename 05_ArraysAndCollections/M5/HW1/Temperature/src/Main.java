public class Main {
    public static void main(String[] args) {
        final int MAX = 40;
        final int MIN = 32;
        final int MAX_PATIENT = 5;
        final double MIN_TEMPERATURE_HEALTHY_PATIENT = 36.2;
        final double MAX_TEMPERATURE_HEALTHY_PATIENT = 36.9;
        int healthy_patient = 0;
        double middleTemperature = 0;
        double[] arrPatient = new double[MAX_PATIENT];
        for (int i = 0; i < MAX_PATIENT; i++) {
            arrPatient[i] = Math.random() * (MAX - MIN + 1) + MIN;
            if (arrPatient[i] >= MIN_TEMPERATURE_HEALTHY_PATIENT && arrPatient[i] <= MAX_TEMPERATURE_HEALTHY_PATIENT) {
                healthy_patient++;
            }
            System.out.printf("Пациент №%d Температура: %.2f \n", (i + 1), arrPatient[i]);
            middleTemperature += arrPatient[i]/MAX_PATIENT;
        }
        //midl = midl / MAX_PATIENT;
        System.out.printf("Средняя температура %.2f\nКоличество здоровых пациентов: %d ", middleTemperature, healthy_patient);
    }
}
