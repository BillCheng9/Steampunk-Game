# CHOOSE PET

Brief Description:
1. user clicks on their 'INVENTORY' button
2. the system reads the input and opens up the INVENTORY UI
3. user clicks 'EQUIP' on the pet that they want

```plantuml

<style>
diamond {
  BackgroundColor White
}
</style>

title Choose Pet

start
#lavender: User clicks on INVENTORY;
#pink: Opens up INVENTORY UI;
#pink: Pets and corresponding information show up;
#lavender: User clicks on EQUIP next to the pet they want;
while (Happy with Pet decision) is (No)
#lavender: User clicks on EQUIP on a different Pet;
endwhile (Yes)
#lavender: User clicks on ACCEPT;
#pink: Closes INVENTORY UI;
#pink: Updates Player information and stats;
#pink: Save current information;
