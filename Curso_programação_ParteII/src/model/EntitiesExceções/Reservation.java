package model.EntitiesExceções;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptionsExceções.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// FORMATO DE DATA PARA EXIBIR AS DATAS DE CHECK-IN E CHECK-OUT COMO STRINGS
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// CONSTRUTOR QUE INICIALIZA A RESERVA COM NÚMERO DO QUARTO, CHECK-IN E CHECK-OUT
	// LANÇA UMA EXCEÇÃO SE A DATA DE CHECK-OUT NÃO FOR APÓS A DATA DE CHECK-IN
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {	// RETORNA O NÚMERO DO QUARTO
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {	// DEFINE O NÚMERO DO QUARTO
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {	// RETORNA A DATA DE CHECK-IN
		return checkIn;
	}
	public Date getCheckOut() {	// RETORNA A DATA DE CHECK-OUT
		return checkOut;
	}
	public long duration() {// CALCULA E RETORNA A DURAÇÃO DA ESTADIA EM DIAS
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	// ATUALIZA AS DATAS DE CHECK-IN E CHECK-OUT DA RESERVA
	// LANÇA UMA EXCEÇÃO SE AS NOVAS DATAS NÃO FOREM FUTURAS OU SE A DATA DE CHECK-OUT NÃO FOR APÓS A DATA DE CHECK-IN
	public void updateDates(Date checkIn, Date checkOut) {
	    // CRIA UM OBJETO DATE REPRESENTANDO A DATA ATUAL
	    Date now = new Date();

	    // VERIFICA SE AS NOVAS DATAS SÃO FUTURAS
	    if (checkIn.before(now) || checkOut.before(now)) {
	        throw new DomainException("Reservation dates for update must be future dates");
	    }

	    // VERIFICA SE A DATA DE CHECK-OUT É APÓS A DATA DE CHECK-IN
	    if (!checkOut.after(checkIn)) {
	        throw new DomainException("Check-out date must be after check-in date");
	    }

	    // ATUALIZA O CHECK-IN E O CHECK-OUT COM AS NOVAS DATAS
	    this.checkIn = checkIn;
	    this.checkOut = checkOut;
	}

	// RETORNA UMA STRING REPRESENTANDO A RESERVA COM NÚMERO DO QUARTO, DATAS DE CHECK-IN E CHECK-OUT E DURAÇÃO EM NOITES
	@Override
	public String toString() {
		return "Room "
			+ roomNumber 
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}
}
