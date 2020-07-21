#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: BLOC
#------------------------------------------------------------

CREATE TABLE BLOC(
        BLOC_NUM           Int NOT NULL ,
        BLOC_HASH          Varchar (500) NOT NULL ,
        BLOC_NBTRANSACTION Int NOT NULL ,
        BLOC_DATE          Varchar (50) NOT NULL
	,CONSTRAINT BLOC_PK PRIMARY KEY (BLOC_NUM)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRANSACTION
#------------------------------------------------------------

CREATE TABLE TRANSACTION(
        Transaction_hash Varchar (200) NOT NULL ,
        BLOC_NUM         Int NOT NULL
	,CONSTRAINT TRANSACTION_PK PRIMARY KEY (Transaction_hash)

	,CONSTRAINT TRANSACTION_BLOC_FK FOREIGN KEY (BLOC_NUM) REFERENCES BLOC(BLOC_NUM)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ENTREE
#------------------------------------------------------------

CREATE TABLE ENTREE(
        ENTREE_ID      Varchar (200) NOT NULL ,
        ENTREE_ADDRESS Varchar (200) NOT NULL ,
        ENTREE_MONTANT Float NOT NULL
	,CONSTRAINT ENTREE_PK PRIMARY KEY (ENTREE_ID)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: SORTIE
#------------------------------------------------------------

CREATE TABLE SORTIE(
        SORTIE_ID      Varchar (200) NOT NULL ,
        SORTIE_ADDRESS Varchar (200) NOT NULL ,
        SORTIE_MONTANT Float NOT NULL
	,CONSTRAINT SORTIE_PK PRIMARY KEY (SORTIE_ID)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRANSACTION_ENTREE
#------------------------------------------------------------

CREATE TABLE TRANSACTION_ENTREE(
        ENTREE_ID        Varchar (200) NOT NULL ,
        Transaction_hash Varchar (200) NOT NULL
	,CONSTRAINT TRANSACTION_ENTREE_PK PRIMARY KEY (ENTREE_ID,Transaction_hash)

	,CONSTRAINT TRANSACTION_ENTREE_ENTREE_FK FOREIGN KEY (ENTREE_ID) REFERENCES ENTREE(ENTREE_ID)
	,CONSTRAINT TRANSACTION_ENTREE_TRANSACTION0_FK FOREIGN KEY (Transaction_hash) REFERENCES TRANSACTION(Transaction_hash)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRANSACTION_SORTIE
#------------------------------------------------------------

CREATE TABLE TRANSACTION_SORTIE(
        SORTIE_ID        Varchar (200) NOT NULL ,
        Transaction_hash Varchar (200) NOT NULL
	,CONSTRAINT TRANSACTION_SORTIE_PK PRIMARY KEY (SORTIE_ID,Transaction_hash)

	,CONSTRAINT TRANSACTION_SORTIE_SORTIE_FK FOREIGN KEY (SORTIE_ID) REFERENCES SORTIE(SORTIE_ID)
	,CONSTRAINT TRANSACTION_SORTIE_TRANSACTION0_FK FOREIGN KEY (Transaction_hash) REFERENCES TRANSACTION(Transaction_hash)
)ENGINE=InnoDB;

