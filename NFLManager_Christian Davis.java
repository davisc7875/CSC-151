public static class Coaches {

        static void showCoaches() {

            String coachesMenu =
                "Carolina Panthers Coaches\n" +
                "--------------------------\n" +
                "Head Coach: Dave Canales\n" +
                "Offensive Coordinator: Brad Idzik\n" +
                "Secondary Coach: Renaldo Hill\n" +
                "Defensive Line: Todd Wash\n" +
                "Running Backs: Bernie Parmalee\n" +
                "Senior Defensive Assistant:\n" +
                "Defensive Coordinator: Ejiro Evero\n";

            JOptionPane.showMessageDialog(null, coachesMenu,
                    "Coaches", JOptionPane.INFORMATION_MESSAGE);
        }
    }