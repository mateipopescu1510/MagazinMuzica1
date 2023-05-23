# PROIECT PAO
Proiectul are la baza un magazin online de muzica. Clientii pot comanda diferite produse, precum instrumente, amplificatoare, albume, etc.
Tipurile de obiecte sunt:
* Client - date despre un client. Implementeaza ClientService, ceea ce permite efectuarea unei comenzi pentru un client, sa calculeze costul, etc. 
* Courier - date despre o companie de curierat
* Distributor - date despre distributorii ai caror produse sunt vandute de magazin
* Employee - date despre un angajat
* Product - clasa de baza abstracta care contine date generale despre un produs, care poate fi de 3 tipuri
* Intrument - clasa derivata a tipului Product
* Amplifier - clasa derivata a tipului Product
* Album - clasa derivata a tipului Product
* Order - contine o lista de produse dintr-o comanda, si date in plus (status, cine indeplineste comanda, etc.)
* Shop - este Singleton, implementeaza ShopService, ceea ce permite adaugarea, eliminarea, cautarea produselor dupa nume, etc.

Actiunile disponibile unui manager al magazinului sunt:
1. Adaugarea unui client
2. Crearea unei comenzi
3. Anularea unei comenzi
4. Adaugarea unui produs in stoc
5. Calculul costului tuturor comenzilor unui client
6. Afisarea comenzilor unui client sortate dupa pret
7. Afisarea stocului curent al magazinului
8. Afisarea produselor comandate de un client
9. Adaugarea unui nou distribuitor
10. Confirmarea unei comenzi ca fiind indeplinita
11. Afisarea tuturor clientilor
12. Adaugarea unui nou angajat
13. Eliminarea unui angajat
14. Afisarea tuturor angajatilor
15. Adaugarea unei companii de curierat
16. Afisarea tuturor companiilor de curierat
