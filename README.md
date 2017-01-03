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
