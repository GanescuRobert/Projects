class Recipe 
{
private:

	string name;
	Table nutritionalTable;
	map<string,int> ingredientsQuantiti;
	string howToMake;

	void readName();
	void readIngredientsQuantiti();
	void readTable();
	void readHowToMake();

	void createRecipe();
public:
	
	Recipe() {
		createRecipe();
	}

	void printName();
	void printIngredientsQuantiti();
	void printTable();
	void printHowToMake();

	void printRecipe();

	map<string, int> getIngredientsQuantiti();
	string getName();
	string getHowTomake();
	Table getNutritionalTable();

};