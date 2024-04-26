package script.quest.util;

import script.library.buff;
import script.library.groundquests;
import script.location;
import script.menu_info_types;
import script.obj_id;

public class retrieve_item_shmi_buff extends script.base_script
{
    public retrieve_item_shmi_buff()
    {
    }
    public int OnObjectMenuSelect(obj_id self, obj_id player, int item) throws InterruptedException
    {
        location here = getLocation(player);
        location term = getLocation(self);
        float dist = getDistance(here, term);
        if (hasScript(player, "quest.task.ground.retrieve_item"))
        {
            if (groundquests.playerNeedsToRetrieveThisItem(player, self))
            {
                if (item == menu_info_types.ITEM_USE)
                {
                    if (isDead(player) || isIncapacitated(player) || dist > 5.0)
                    {
                        return SCRIPT_CONTINUE;
                    }
                    buff.applyBuff(player, "shmiGraveBuff");
                }
            }
        }
        return SCRIPT_CONTINUE;
    }
}
