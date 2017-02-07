# eWallet
An open and simple eWallet API.

Credit amount to account
https://EW/AddMoney/{accId}/{amount}

Debit amount to account
https://EW/RemoveMoney/{accId}/{amount}

Funds Transfer betweeen one account to another account
https://EW/SendMoney/{debitAccId}/{amount}/{creditAccId}

Funds Transfer Internal betweeen one account to another account
https://EW/FundsTransfer/InternalAccount/{debitAccId}/{amount}/{creditAccId}

Funds Transfer External betweeen one account to another account
https://EW/FundsTransfer/ExternalAccount/{debitAccId}/{amount}/{creditAccId}


#####
http://stackoverflow.com/questions/20414548/spring-3-javaconfig-problems-injecting-datasource
http://viralpatel.net/blogs/spring-4-mvc-tutorial-maven-example/
http://stackoverflow.com/questions/28893796/returning-a-simple-map-structure-from-spring-mvc-controller-to-ajax

