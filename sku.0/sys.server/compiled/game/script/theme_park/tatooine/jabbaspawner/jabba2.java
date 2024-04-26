package script.theme_park.tatooine.jabbaspawner;

import script.obj_id;

public class jabba2 extends script.base_script
{
    public jabba2()
    {
    }
    public int OnDestroy(obj_id self) throws InterruptedException
    {
        obj_id palace = getObjIdObjVar(self, "palace");
        messageTo(palace, "jabba2Died", null, 20, true);
        return SCRIPT_CONTINUE;
    }
}
