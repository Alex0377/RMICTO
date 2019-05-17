package com.rmi.shared;


import java.io.FileNotFoundException;
import java.rmi.*;
import java.sql.SQLException;

/**
 *интерфейс сервиса билдингсервиса наследует свойста джава рми ремоте и включает методы работы с катой
 * во всех методах присустствует обьект кард пеедаваймый по серти между двумя жава приложениями
 */
public interface BillingService extends Remote
{
	/**
	 * Регистрация нового пользователя
	 * @param card
	 * @throws RemoteException
	 */
	public void addNewCostomer(СustomerCard card) throws RemoteException ;

	/**
	 *  Регистрация нового пользователя
	 * @param card
	 * @throws RemoteException
	 */
	public void addinfoCostomer(СustomerCard card) throws RemoteException ;

}
