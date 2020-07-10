#include "alllibs.h"

void Recipe::readName() {
	cout << "Recipe name: "; getline(cin, name);
}
void Recipe::readIngredientsQuantiti() {
	int ingredientsNumber;
	cout << "number of ingredients: "; cin >> ingredientsNumber;
	for (int i = 0; i < ingredientsNumber; i++) {
		string tempIngredient;
		int tempQuantiti;
		cout << "ingredient: ";	getline(cin>>ws,tempIngredient);
		cout << "quantiti: ";		cin >> tempQuantiti;
		ingredientsQuantiti[tempIngredient] = tempQuantiti;
	}
}
void Recipe::readTable() {
	nutritionalTable.readTable();
}
void Recipe::readHowToMake() {
	cout << "how to make: "; getline(cin>>ws, howToMake);
}

void Recipe::createRecipe() {
	readName();
	nutritionalTable.readTable();
	readIngredientsQuantiti();
	readHowToMake();
}

void Recipe::printName() {
	cout <<"Recipe name: "<< name << endl;
}
void Recipe::printIngredientsQuantiti() {
	cout << "\nnumber of ingredients: " << ingredientsQuantiti.size() << endl;
	for (auto it : ingredientsQuantiti) 
		cout << "ingredient: " << it.first << '\t'<< "quantiti: " << it.second << endl;
	
}
void Recipe::printTable() {
	nutritionalTable.printTable();
}
void Recipe::printHowToMake() {
	cout << "how to make:\n" << howToMake;
}

void Recipe::printRecipe() {
	cout << endl << endl;
	printName();
	nutritionalTable.printTable();
	printIngredientsQuantiti();
	printHowToMake();
	cout << endl << endl;
}

map<string, int> Recipe::getIngredientsQuantiti() {
	return ingredientsQuantiti;
}
string Recipe::getName() {
	return name;
}
string Recipe::getHowTomake() {
	return howToMake;
}
Table Recipe::getNutritionalTable() {
	return nutritionalTable;
}
