# An easy reward system for the Java platform. #

reward4j is intended to simplify the reward of certain actions within an application which users execute. The reward system uses a simple currency model (_coins_). Each user has an internal account that increases or decreases the coins due to the executed action the user has triggered.

### Annotation based ###
Technically all is done by using an annotation that defines which action is active and how rewarding the executing of this action is. I.e.

```
 @Payable(action="EnrichDocument", coins=1)
 void addTagToDocument(Tag tag, Document document);
```

If an user executes the method `addTagToDocument`, then the appropriate account of the user will be increased by one coin.

```
 @Payable(action="EnrichDocument", coins=5)
 void commentDocument(Comment comment, Document document);
```

If an user executes the method `commentDocument`, then 5 coins will be credited to the user's account.

Both methods use the same action with the name `EnrichDocument`. The account has got positions like a real bank account. Each position refers to its action. Thus it is possible to create overviews which depict what a user has done within the application flow.

```
 @Payable(action="RemoveDocument", coins=-20)
 void removeDocument(Document document);
```

If an user removes a document by using the method `removeDocument`, his account will be debit with the amount of 20 coins.

```
 @Restrictable(coins=500, decider=BalanceHigherDecider.class)
 void addComment(String comment);
```

If an user wants to add a comment in a specific situation the execution of the approbiate method is restricted to the user's account balance which should be higher than the configured amount of 500 coins.

```
 @Restrictable(coins=10, decider=BalanceLowerDecider.class)
 void add(String comment);
```

In some cases it might be necessary that a method should only be executed if an user has not reached a given account balance. In these situations the `@Restrictable` annotation can be configured with the `BalanceLowerDecider` class.

In order to ensure a high level of flexibility, the `@Restrictable` annotation can also be configured with an individuell `RestrictionDecider` implementation.

### Account Management ###
reward4j offers a certain service class to look into the accounts of all known users. Though an application that uses reward4j has the possibility to work with the current account balance. For example an application could interrupt any actions / execution of methods as long as the account balance of the current user hasn't got the appropriate amount.