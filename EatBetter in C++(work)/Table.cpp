#include "alllibs.h"

void Table::printTable() {
	cout << "calories: " << calories
		<< "\nfats: " << fats
		<< "\nsatured fats: " << saturedFats
		<< "\nproteins: " << proteins
		<< "\ncarbohydrates: " << carbohydrates
		<< "\nsugar: " << sugar
		<< "\nfiber: " << fiber
		<< "\nnumber of portions: " << portionsNumber
		<< "\ntime to cook: " << cookingTime;

}
void Table::readTable() {
	cout << "calories:\t";				cin >> calories;
	cout << "fats:\t";					cin >> fats;
	cout << "saturedFats:\t";			cin >> saturedFats;
	cout << "proteins:\t";				cin >> proteins;
	cout << "carbohydrates:\t";			cin >> carbohydrates;
	cout << "sugar:\t";					cin >> sugar;
	cout << "fiber:\t";					cin >> fiber;
	cout << "number of portions:\t";	cin >> portionsNumber;
	cout << "cooking time:\t";			cin >> cookingTime;
}

int Table::getCalories() {
	return calories;
}
int Table::getFats() {
	return fats;
}
int Table::getSaturedFats() {
	return saturedFats;
}
int Table::getProteins() {
	return proteins;
}
int Table::getCarbohydrates() {
	return carbohydrates;
}
int Table::getSugar() {
	return sugar;
}
int Table::getFiber() {
	return fiber;
}
int Table::getPortionsNumber() {
	return portionsNumber;
}
int Table::getCookingTime() {
	return cookingTime;
}