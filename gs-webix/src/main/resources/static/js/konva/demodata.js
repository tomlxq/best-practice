var option_data = [
    { id:1, value:"Books"},
    { id:2, value:"Films"},
    { id:3, value:"Music"}
];

var grid_data = [
    { id:1, title:"The Shawshank Redemption", year:1994, votes:678790, rating:9.2, rank:1},
    { id:2, title:"The Godfather", year:1972, votes:511495, rating:9.2, rank:2},
    { id:3, title:"The Godfather: Part II", year:1974, votes:319352, rating:9.0, rank:3},
    { id:4, title:"The Good, the Bad and the Ugly", year:1966, votes:213030, rating:8.9, rank:4},
    { id:5, title:"My Fair Lady", year:1964, votes:533848, rating:8.9, rank:5},
    { id:6, title:"12 Angry Men", year:1957, votes:164558, rating:8.9, rank:6}
];

var list_data = [
    { id:1, value:"The Shawshank Redemption"},
    { id:2, value:"The Godfather"},
    { id:3, value:"The Godfather: Part II"},
    { id:4, value:"The Good, the Bad and the Ugly"},
    { id:5, value:"My Fair Lady"},
    { id:6, value:"12 Angry Men"}
];

var tree_data = [
    { id: "1", type: "folder", value: "Music", data: [
        { id: "m_0", type: "folder", value: "Jimi Hendrix", data: [
            { id: "m_0_1", type: "file", value: "1967 - Are You Experienced?"},
            { id: "m_0_2", type: "file", value: "1967 - Axis: Bold As Love"},
            { id: "m_0_3", type: "file", value: "1968 - Electric Lady Land"}
        ]},
        { id: "m_1", type: "folder", value: "Georgy Sviridov", data: [
            { id: "m_1_0", type: "file", value: "Petersburg a Vocal Poem"},
            { id: "m_1_1", type: "file", value: "A Russia Flying Away"}
        ]},
        { id: "m_2", type: "folder", value: "God is an Astronaut", data: [
            { id: "m_2_0", type: "file", value: "2005 - All Is Violent, All Is Bright"},
            { id: "m_2_1", type: "file", value: "2007 - Far from Refuge"},
            { id: "m_2_2", type: "file", value: "2010 - Age of the Fifth Sun"}
        ]},
        { id: "m_3", type: "folder", value: "Nikolai Rimsky-Korsakov", data: [
            { id: "m_3_1", type: "file", value: "Scheherazade"}
        ]}
    ]},
    { id:"2", type: "folder", value:"Images", data:[
        { id: "p_0", type: "folder", value: "01 - Christmas", data: [
            { id: "p_0_0", type: "file", value: "IMG_10034" },
            { id: "p_0_1", type: "file", value: "IMG_10035" },
            { id: "p_0_2", type: "file", value: "IMG_10036" },
            { id: "p_0_3", type: "file", value: "IMG_10037" },
            { id: "p_0_4", type: "file", value: "IMG_10038" },
            { id: "p_0_5", type: "file", value: "IMG_10039" },
            { id: "p_0_6", type: "file", value: "IMG_10040" },
            { id: "p_0_7", type: "file", value: "IMG_10041" },
            { id: "p_0_8", type: "file", value: "IMG_10042" }
        ]},
        { id: "p_1", type: "folder", value: "02 - New Year's Eve", data: [
            { id: "p_1_0", type: "file", value: "DSC10384" },
            { id: "p_1_1", type: "file", value: "DSC10385" },
            { id: "p_1_2", type: "file", value: "DSC10386" },
            { id: "p_1_3", type: "file", value: "DSC10387" },
            { id: "p_1_4", type: "file", value: "DSC10388" },
            { id: "p_1_5", type: "file", value: "DSC10389" },
            { id: "p_1_6", type: "file", value: "DSC10390" }
        ]},
        { id: "p_2", type: "folder", value: "03 - Justin's Concert", data: [
            { id: "p_2_0", type: "file", value: "IMG_14021" },
            { id: "p_2_1", type: "file", value: "IMG_14022" },
            { id: "p_2_2", type: "file", value: "IMG_14023" },
            { id: "p_2_3", type: "file", value: "IMG_14024" },
            { id: "p_2_4", type: "file", value: "IMG_14025" },
            { id: "p_2_5", type: "file", value: "IMG_14026" },
            { id: "p_2_6", type: "file", value: "IMG_14027" },
            { id: "p_2_7", type: "file", value: "IMG_14028" },
            { id: "p_2_8", type: "file", value: "IMG_14029" },
            { id: "p_2_9", type: "file", value: "IMG_14030" }
        ]}
    ]},
    { id: "3", type: "folder", value: "Video", data:[
        { id: "v_0", type: "folder", value: "Fitness", data: [
            { id: "v_0_0", type: "file", value: "Step Aerobics Routine" },
            { id: "v_0_1", type: "file", value: "Tae Bo Training" },
            { id: "v_0_2", type: "file", value: "Water Aerobics" }
        ]},
        { id: "v_1", type: "folder", value: "Workouts", data: [
            { id: "v_1_0", type: "file", value: "01 - Pushups" },
            { id: "v_1_1", type: "file", value: "02 - Incline Dumbbell Press" },
            { id: "v_1_2", type: "file", value: "03 - Dips - Chest Version" },
            { id: "v_1_3", type: "file", value: "04 - Dumbbell Bench Press" },
            { id: "v_1_4", type: "file", value: "05 - Incline Cable Flye" }
        ]},
        { id: "v_2", type: "folder", value: "Yoga", data: [
            { id: "v_2_0", type: "file", value: "01 - Bird of Paradise Pose"},
            { id: "v_2_1", type: "file", value: "02 - Boat Pose"},
            { id: "v_2_2", type: "file", value: "03 - Bow Pose"},
            { id: "v_2_3", type: "file", value: "04 - Bridge Pose"}
        ]}
    ]}
];