Any inquiries or problems, feel free to open an Issue. 

# Android Discord LINE Stickers

Provide an easy way to use LINE stickers with Android Discord, inspired by another project on GitHub: [BetterDiscord Line Stickers Plugin.](https://github.com/awaken1ng/bd-linestickers)
![enter image description here](https://lh3.googleusercontent.com/adrXdOBX-BPlvWLVDHTPVK2LB18adXwvZ9wNMqUh0dn7N7TqlD2x3k4YkdS2t4f2jAQsGAHJrOBtPNtCe8j8q-BXRwTqDTJce9o2DXaQQl-w96qC4hUIzQykcw1poSRepYOJmlmldKWZPVkVrCcZsCdYOdzQqgRZKBRHjIII8LTJKMpxrQLBpf-b0g_l1GdZ1UaTW7i4DoErAb8oBClz6e2M4n87rk-YFkD-3GvOvGyqZmLz7UFWd7smcIqXg2Ue8JHsJqgFiz0OB2rxziZXIfarezv4NunnJeXGf7VO5SE0I1kYfufzOfj4eg9vEEHMQ-4126-7gqfzKOBop6rh8SqSjMUlDC6nkMhzebIc8t9TSUVA9JWaIifmOYGU8zeCFui9trA5cE5GHVL2Kb7LVRlmDM_5_LFsOWzBU431C2tdq_vFlHyWfREKmJX8PHeN33KRBBP3SZofDZwWc8ebwN2cOrQy665GeFOVXPoDSXUFL9_DSm3WA4Bn6z-cgrKd8G8w5FWxacpcVfavP5lcmDBMXfSEnvdMk_NLLb7AEXtlFT2FB9-tfV2qMlQeFS8oe7eUOHuqI6IpuSatwaDeFISTDGmQ-XTRFrKZNGk=w720-h616-no)

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
![enter image description here](https://lh3.googleusercontent.com/Cfsg1M5hFYjt2Wsd1tk_Nq62KCeD6WfQS9NzyTDF9W57KUzDrMRt5nWLsgXQt5YThVjDkIXaIUIx)
 1. For Firefox users, right click on the first sticker, then select **Inspect Element**; for Chrome users, right click on the first sticker, then select **Inspect**
 2. Look at the .../sticker/*[some numbers here]*/android/... part, those numbers are the **sticker ID**
 3. For the **count**, you can find out easily by counting the amount of stickers in the pack. Usually the standard for most sticker packs is 40. ( *there is exception to every rule :P* )

## Editing stickers
You can edit your stickers by pressing Menu button > Edit
![enter image description here](https://lh3.googleusercontent.com/XiABvhg4j_6_CorbBuAwI_Iatk-SH6jxF2KFLPxHsQ9NzAmZg6Px5zZJVoxnghfFh6KQ7OtecdS_)
 - To change the sticker's title, ID or count, press on the sticker once. A *familiar* dialog should show up. 
 - To remove sticker, swipe it to either left or right
 - To reorder sticker, press and hold on it, then drag-and-drop to the position you want it to be
 - Note: Remember to press the **Save** button, no changes are made otherwise

## How to use the stickers
Simple ;-)

 1. Press once on the sticker that you wish to use, its URL will then being copied to your clipboard automatically
 2. Switch to Discord, then **paste** the copied URL to the text box
 3. Lastly, press on the **send** button ( *ofcuz!* )
