package dao.operation_banque;

import dao.BD;
import dao.IOperations;
import dao.OperationsImpl;

public class CourantOperationImpl implements IOperation_Bancaire {
	private BD bd;
	private IOperations ioperation;
	
	public CourantOperationImpl() {
		bd= new BD();
		ioperation = new OperationsImpl();
	}

	@Override
	public String virementBancaireOperation(int compteDestinataire, int montant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String depotBancaireOperation(int compteDestinataire, int montant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String RetraitBancaireOperation(int compteDestinataire, int montant) {
		// TODO Auto-generated method stub
		return null;
	}

}
