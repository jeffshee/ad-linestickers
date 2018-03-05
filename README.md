Any inquiries or problems, feel free to open an Issue. 

# Android Discord LINE Stickers

Provide an easy way to use LINE stickers with Android Discord, inspired by another project on GitHub: [BetterDiscord Line Stickers Plugin.](https://github.com/awaken1ng/bd-linestickers)

## Adding stickers

### Getting stickers

Find the stickers on [LINE Store](https://store.line.me/home/en) ( ※Note: you don't need to buy them )
To add a sticker pack you'll need:

 - It's title (optional but please at least fill in something)
 - The ID of the first sticker
 - Total count of stickers in the pack

Here are the steps:
 1. Open the dialog by pressing the Menu button > Add
 2. The following dialog should show up
 3. Enter the title, amount of stickers in the pack and the ID of the first sticker, then press OK

### Getting sticker's ID and sticker count ( PC is recommended )
**Grease/Tampermonkey user script**
If you're using **Greasemonkey** or **Tampermonkey** you can [download this user script](https://greasyfork.org/en/scripts/23630), which will show you the first sticker ID and the sticker count

**Manual way**
Sometimes manual way is more preferable as it doesn't require you to install anything

 1. For Firefox users, right click on the first sticker, then select **Inspect Element**; for Chrome users, right click on the first sticker, then select **Inspect**
 2. Look at the .../sticker/*[some numbers here]*/android/... part, those numbers are the **sticker ID**
 3. For the **count**, you can find out easily by counting the amount of stickers in the pack. Usually the standard for most sticker packs is 40. ( *there is exception to every rule :P* )

## Editing stickers
You can edit your stickers by pressing Menu button > Edit

 - To change the sticker's title, ID or count, press on the sticker once. A *familiar* dialog should show up. 
 - To remove sticker, swipe it to either left or right
 - To reorder sticker, press and hold on it, then drag-and-drop to the position you want it to be
 - Note: Remember to press the **Save** button, no changes are made otherwise

## How to use the stickers
Simple ;-)

 1. Press once on the sticker that you wish to use, its URL will then being copied to your clipboard automatically
 2. Switch to Discord, then **paste** the copied URL to the text box
 3. Lastly, press on the **send** button ( *ofcuz!* )

