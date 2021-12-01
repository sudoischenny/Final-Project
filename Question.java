class Question
{

 String question;
 String choiceOne;
 String choiceTwo;
 String choiceThree;
 String choiceFour;
 int answer;
 int points;
 String category;

// Add constructor with multiple paramenters
Question(String aQuestion, String achoiceOne, String achoiceTwo, String achoiceThree, String achoiceFour, int anAnswer, int thePoints, String aCategory)
{
question = aQuestion;
choiceOne = achoiceOne;
choiceTwo = achoiceTwo;
choiceThree = achoiceThree;
choiceFour = achoiceFour;
answer = anAnswer;
points = thePoints;
category = aCategory;

}
//Add Accessor methods 
String getQuestion()
{
 return question;
}

String getChoiceOne()
{
  return choiceOne;
}

String getChoiceTwo()
{
  return choiceTwo;
}

String getChoiceThree()
{
  return choiceThree;
}

String getChoiceFour()
{
  return choiceFour;
}

int getAnswer()
{
  return answer;
}

int getPoints()
{
  return points;
}

String getCategory()
{
  return category;
}

}