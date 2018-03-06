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
![enter image description here](https://lh3.googleusercontent.com/SwCWS28mfBHi6D8Q0hMT_V6yzI8mdDJB4mwypf6ZtJOoZsvZEr6CUxYQmrVAO7Oa259Mgp6N_CxpO5axMzlHBK1CUgoqy54qKT16kCsNLVUFgHYjs9j5gBtc6QwRov86l0MWNKu95rfCFtI77fyHKnn5llTK-bR6PJ7xHYGP5JWV84SUYYH4DCyM_K0OklyFfItb1Zi0WSEMe9myX84cOQG4ujb25Kl1nqygulFrQnuV2wq5gwPwEGScYZETnJmo6vs9priX6HUmd58mpSbOEvecovXpeWwgNQJmWOhox0A8vhhxRXj_4qvz85fP4YH-Jl62Fi7oS29zYqSLgbCNbCF5BR0VTcFM3U4z2PjUPtoiGSaEGrxlL0VX6-UD-7WCQv_g37Ix-vxjrRkWuavcFp-4bpeWJ1ld2XhV4PwdwqJYHJQNfEIq_fu9-qdJI7bHWH3HIEnKwIE8wm_wo_JZH762iUTXKHA2KiwPFBnKV4MzQ60PF0FTx509kIpwSfhKvjegT8sCbSZtyNCercrLeK1kPeKUcIZvmGK2Bdg84bObj_DLYwfTpZAcN1ZtC9y4O8NTzY30inhEnHfxgOWJ4--9rP2nt5pKsjJn2OE=w1624-h914-no)
 1. For Firefox users, right click on the first sticker, then select **Inspect Element**; for Chrome users, right click on the first sticker, then select **Inspect**
 2. Look at the .../sticker/*[some numbers here]*/android/... part, those numbers are the **sticker ID**
 3. For the **count**, you can find out easily by counting the amount of stickers in the pack. Usually the standard for most sticker packs is 40. ( *there is exception to every rule :P* )

## Editing stickers
You can edit your stickers by pressing Menu button > Edit  
![enter image description here](https://lh3.googleusercontent.com/s6IodheZR3xm5sp7oSlydNnf2aZ2jYE9RBvpLbsSyQKYITMesoL_uSPkmW_FFOxaHmtN29bJPWSnoQfjwL8S0KXyjG62ZPTHyqOLq4G82QK_O6TlsL2zl1_IeyRyjePUtCNLfYfSEwb-7rzSXjtmPrp5ogmwoXpre7_VuhQ6GydtvynyDz4xr5xBYsa11XnzGxNP8O3nx1FKS15mOiWk0zkHi4frETeXSUB2YLQi4e0jeLGsVya602ydhg-htY6jp_MVOsm4PcFhduTpgpUWgqvuX6aLHmmNuTYFyXgQdXAGmi7u7RfWu9CeuX6HkUDCCqSeCg9O4y1CnXDObbpUxTorm6V_WYKsl5sy6WdJgLZDzxNtOnhGSgtnkL4P4LOGBptOHd3UtT4lsQzLfBqoCIyBGVHfICfex4QSgb9PXCfxIUoiZT9qKG5f9oilfCCrwAkHr0SN0efxbc5XIrF29QpuSJD8Y_kVRwpMnU5ykOxsr63oyBdwUmVrtAeLCaIk_cdVtUenVL03CPBkSUU-UrCeflhOvdaxdZRQL8nruXPEU2-ObPqhJLkXTfLeMJbAIQshxfKK6fj-LTV3PkdN4Qg48VhDrK-3A5BPR0Q=w720-h616-no)
 - To change the sticker's title, ID or count, press on the sticker once. A *familiar* dialog should show up. 
 - To remove sticker, swipe it to either left or right
 - To reorder sticker, press and hold on it, then drag-and-drop to the position you want it to be
 - Note: Remember to press the **Save** button, no changes are made otherwise

## How to use the stickers
Simple ;-)

 1. Press once on the sticker that you wish to use, its URL will then being copied to your clipboard automatically
 2. Switch to Discord, then **paste** the copied URL to the text box
 3. Lastly, press on the **send** button ( *ofcuz!* )
