
Questo piccolo progetto (in corso) potrebbe tornare utile a tutte quelle associazioni che si occupano di banco alimentare o di distribuzione viveri.

_____________________________________________________________________________________________________________________

SPIEGAZIONE ENTITA'

Zona 		-> le famiglie che usufruiscono degli aiuti alimentari e che provengono dalla stessa zona (luogo) della città, portanno essere inserite per l'appunto nella stessa zona d'interesse, in modo da semplificare il lavoro (per l'associazione) di distribuzione viveri.

Famiglie 	-> le famiglie possono avere vari componenti, e qualora vi siano particolari richieste possono essere inserite nel campo "note". E' importante far notare che ogni famiglia ha un solo referente.

Referente 	-> Il referente è colui che presenta la richiesta per ricevere aiuti alimentari, o colui che si fa carico del ritiro degli alimenti.

Distribuzioni 	-> una distribuzione (di viveri) è composta da più prodotti, e può essere effettuata verso più famiglie alla volta.

Prodotti 	-> prodotti inseriti all'interno del pacco alimentare.

_____________________________________________________________________________________________________________________

SPIEGAZIONE RELAZIONI TABELLE

- ( 1 to n ) 
Ad ogni zona possono appartenere più famiglie, ma una famiglia può appartenere ad una sola zona.
     
- ( 1 to 1 ) 
Ogni famiglia possiede un singolo referente, ed ogni referente può appartenere ad una sola famiglia.

- ( n to n )
Ogni famiglia può ricevere varie distribuzioni (distribuzione di viveri si intende), ed ogni distribuzione può essere effettuata a più famiglie.

- ( n to n ) 
Ogni distribuzione può possedere più di un prodotto, ed ogni prodotto può appartenere a più distribuzioni.

