package ApplcationExceções;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.EntitiesExceções.Reservation;
import model.exceptionsExceções.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// INICIALIZAÇÃO DO FORMATO DE DATA PARA LEITURA E EXIBIÇÃO
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try { 
			// LEITURA DO NÚMERO DO QUARTO
			System.out.print("Room number: ");
			int number = sc.nextInt();

			// LEITURA DA DATA DE CHECK-IN NO FORMATO ESPECIFICADO
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			// LEITURA DA DATA DE CHECK-OUT NO FORMATO ESPECIFICADO
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			// CRIAÇÃO DA RESERVA COM AS INFORMAÇÕES FORNECIDAS
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			// ESPAÇO PARA MELHOR LEITURA
			System.out.println();

			// ENTRADA DE NOVOS DADOS PARA ATUALIZAR A RESERVA
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());  // ATUALIZAÇÃO DA DATA DE CHECK-IN
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next()); // ATUALIZAÇÃO DA DATA DE CHECK-OUT
			
			// ATUALIZAÇÃO DAS DATAS DA RESERVA COM OS NOVOS VALORES
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		// TRATAMENTO DE EXCEÇÃO PARA FORMATO DE DATA INVÁLIDO
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		// TRATAMENTO DE EXCEÇÃO PERSONALIZADA PARA ERROS DE DOMÍNIO
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		// TRATAMENTO DE EXCEÇÃO GENÉRICA PARA ERROS NÃO PREVISTOS
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} 

		// FECHA O SCANNER
		sc.close();
	}
} 
