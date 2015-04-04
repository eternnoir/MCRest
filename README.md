# MCRest ![](https://travis-ci.org/eternnoir/MCRest.svg?branch=develop)
Minecraft REST API Bukkit plugin.

## How to install

Put plugin's .jar file to your bukkit server's plugins dictionary.

### Build yourself.

Download project or use git clone it.

```
$ git clone https://github.com/eternnoir/MCRest.git
$ cd MCRest
```

Run build script.

```
$ sh ./preBuild.sh
```

The MCrest plugin .jar file will store in **./build/libs/MCREST-all-*.jar**

## How to Use
Start Server, you will see some log messages.

```
[11:10:14 INFO]: [McREST] Enabling McREST v0.1
[11:10:14 INFO]: [McREST] Enable
[11:10:14 INFO]: Starting the internal [HTTP/1.1] server on port 8281
[11:10:14 INFO]: [McREST] McRest start success.
[11:10:14 INFO]: [McREST] Listen on 0.0.0.0:8281/mcrest
[11:10:14 INFO]: Server permissions file permissions.yml is empty, ignoring it
[11:10:14 INFO]: Done (2.063s)! For help, type "help" or "?"

```

Now you can ues url to get some infomation.

### Players
Use cUrl test.

```
$ curl -X GET http://127.0.0.1:8281/mcrest/player
```

It will return all player in this server.

```
[
   {
      "name":"Maeksein",
      "uniqueId":"efc3d000-119c-4923-afcd-cb6ffafaaf08",
      "online":false,
      "whitelisted":false,
      "banned":false,
      "firstPlayed":1426216252338
   }
]
```

### Worlds
```
$ curl -X GET http://127.0.0.1:8281/mcrest/world
```

It will return all world information in this server.

```
[
   {
      "allowAnimals":true,
      "allowMonsters":true,
      "gameRules":[
         "commandBlockOutput",
         "doDaylightCycle",
         "doFireTick",
         "doMobLoot",
         "doMobSpawning",
         "doTileDrops",
         "keepInventory",
         "logAdminCommands",
         "mobGriefing",
         "naturalRegeneration",
         "randomTickSpeed",
         "reducedDebugInfo",
         "sendCommandFeedback",
         "showDeathMessages"
      ],
      "name":"world",
      "players":[
         {
            "name":"Maeksein",
            "uniqueId":"efc3d000-119c-4923-afcd-cb6ffafaaf08",
            "online":true,
            "whitelisted":false,
            "banned":false,
            "firstPlayed":1426216252338,
            "dispalyName":"Maeksein"
         }
      ]
   },
   {
      "allowAnimals":true,
      "allowMonsters":true,
      "gameRules":[
         "commandBlockOutput",
         "doDaylightCycle",
         "doFireTick",
         "doMobLoot",
         "doMobSpawning",
         "doTileDrops",
         "keepInventory",
         "logAdminCommands",
         "mobGriefing",
         "naturalRegeneration",
         "randomTickSpeed",
         "reducedDebugInfo",
         "sendCommandFeedback",
         "showDeathMessages"
      ],
      "name":"world_nether",
      "players":[

      ]
   },
   {
      "allowAnimals":true,
      "allowMonsters":true,
      "gameRules":[
         "commandBlockOutput",
         "doDaylightCycle",
         "doFireTick",
         "doMobLoot",
         "doMobSpawning",
         "doTileDrops",
         "keepInventory",
         "logAdminCommands",
         "mobGriefing",
         "naturalRegeneration",
         "randomTickSpeed",
         "reducedDebugInfo",
         "sendCommandFeedback",
         "showDeathMessages"
      ],
      "name":"world_the_end",
      "players":[

      ]
   }
]
```
