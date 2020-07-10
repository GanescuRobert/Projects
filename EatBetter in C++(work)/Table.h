class Table {
private:
	int calories;
	int fats;
	int saturedFats;
	int proteins;
	int carbohydrates;
	int sugar;
	int fiber;
	int portionsNumber;
	int cookingTime;
public:
	void readTable();
	void printTable();

	int getCalories();
	int getFats();
	int getSaturedFats();
	int getProteins();
	int getCarbohydrates();
	int getSugar();
	int getFiber();
	int getPortionsNumber();
	int getCookingTime();
};