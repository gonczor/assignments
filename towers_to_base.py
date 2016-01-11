from battle import commander
unit_client = commander.Client()


def search_and_destroy(data=None, *args, **kawargs):
    enemy = unit_client.ask_nearest_enemy()
    tower = unit_client.ask_towers()
    center = unit_client.ask_center()
    chosen_object = None    
    if tower:
        chosen_object = tower[0]['id']
    elif center:
        chosen_object = center['id']
    
    unit_client.do_attack(chosen_object)
    unit_client.when_item_destroyed(chosen_object, search_and_destroy)


search_and_destroy()

