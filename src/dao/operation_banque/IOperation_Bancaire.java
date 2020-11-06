package dao.operation_banque;

public interface IOperation_Bancaire {
	public String executerOperationBancaire(int compteDestinataire,int montant,String nomOperation);
}
