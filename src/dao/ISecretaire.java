package dao;

import model.Secretaire;

public interface ISecretaire {
	public Secretaire findByLoginAndPassword(String login , String password);
}
