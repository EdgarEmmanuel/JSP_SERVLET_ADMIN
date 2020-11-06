package dao.operation_banque;

public interface IOperation_Bancaire {
	public String virementBancaireOperation(int compteDestinataire,int montant);
	public String depotBancaireOperation(int compteDestinataire,int montant);
	public String RetraitBancaireOperation(int compteDestinataire,int montant);
}
