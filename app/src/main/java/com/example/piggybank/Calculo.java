package com.example.piggybank;

import java.math.BigDecimal;
public class Calculo {

    private static Double valorInicial;
    private static Double appMensal;
    private static Integer tempo;
    private static Double taxa;

    public Calculo (double valor, double appMensal, int tempo, double taxa){
        Calculo.valorInicial = valor;
        Calculo.appMensal = appMensal;
        Calculo.tempo = tempo;
        Calculo.taxa = taxa;
    }

    public  Double calcularInvestimento(){
        /*

        VF = VP * (1 + i)^n

        VF é o valor final após o período de tempo
        VP é o valor principal (ou inicial) investido
        i é a taxa de juros anual (dividida por 12, se a taxa mensal)
        n é o número de períodos de tempo em meses
        * */

        double valorAcumulado = getValorInicial();
        double taxaMensal = getTaxa() / 12.0; // divide a taxa anual por 12 para obter a taxa mensal
        for (int i = 0; i < getTempo(); i++) {
            valorAcumulado += getAppMensal(); // adiciona a aplicação mensal ao valor acumulado
            valorAcumulado *= (1.0 + taxaMensal); // calcula o valor final do mês com base no valor acumulado e na taxa mensal
        }
        return valorAcumulado;

    }

    public Calculo() {
    }
    public double calcular() {
        return calcularInvestimento();
    }

    public static void setValorInicial(Double valorInicial) {
        Calculo.valorInicial = valorInicial;
    }

    public static Double getValorInicial() {
        return valorInicial;
    }

    public static Double getAppMensal() {
        return appMensal;
    }

    public static void setAppMensal(Double appMensal) {
        Calculo.appMensal = appMensal;
    }

    public static Integer getTempo() {
        return tempo;
    }

    public static void setTempo(Integer tempo) {
        Calculo.tempo = tempo;
    }

    public static Double getTaxa() {
        return taxa;
    }

    public static void setTaxa(Double taxa) {
        Calculo.taxa = taxa;
    }
}