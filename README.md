# Virtual Pets Amok Project

The application simulates taking care of robotic and organic pets in a shelter. Pets can either be dogs or cats.

**Pet Class and child classes**

The Pet super class has instance variables for health, happiness and a boolean for if the pet is alive. The Organic child class adds hunger, thirst and waste.  The Robotic child class adds rust level. All of the variables are generated randomly when a pet is added to the shelter. They also generate random tick amounts for each value so that they increase by a different value for each pet using their tick method.  There are overridden toString methods that return strings with the stats for that pet.

**PetShelter Class**

This class gathers the pets together in a HashMap.  It has an instance variable for the shelter's Litter Box.  It has methods that allow it to add waste to the litter box, add a pet, find a pet, gather a collection of all of the pets, remove a pet, feed all of the organic pets, water all of the organic pets, oil all of the robotic pets, walk all of the dogs, nap with all of the cats, clean all of the dog cages, clean the litter box, advance the tick methods of all of the pets and show the stats for all of the pets.

**PetShelterApp Class**

This class interacts with the user on the console and provides feedback.  It sends the user instructions to the PetShelter Class.